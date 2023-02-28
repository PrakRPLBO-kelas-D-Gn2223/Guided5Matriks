package com.rplbo.matriks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    /**
     * Rigorous Test :-)
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void tesInitAwalAGetAllEmen(){
        Matriks A = new Matriks();
        A.initAwal(3,3);
        A.setElemenSatuan(0,0,1);
        A.setElemenSatuan(0,1,2);
        A.setElemenSatuan(0,2,3);
        A.setElemenSatuan(1,0,4);
        A.setElemenSatuan(1,1,5);
        A.setElemenSatuan(1,2,6);
        A.setElemenSatuan(2,0,7);
        A.setElemenSatuan(2,1,8);
        A.setElemenSatuan(2,2,9);
        int[][] hasil = {{1,2,3},{4,5,6},{7,8,9}};
        assertArrayEquals(A.getAllElemen(),hasil);
    }

    @Test
    public void tesInitAwalBGetAllElemen(){
        Matriks B = new Matriks();
        B.initAwal(3,3);
        B.setElemenSatuan(0,0,2);
        B.setElemenSatuan(0,1,2);
        B.setElemenSatuan(0,2,2);
        B.setElemenSatuan(1,0,3);
        B.setElemenSatuan(1,1,3);
        B.setElemenSatuan(1,2,3);
        B.setElemenSatuan(2,0,4);
        B.setElemenSatuan(2,1,4);
        B.setElemenSatuan(2,2,4);
        int[][] hasil = {{2,2,2},{3,3,3},{4,4,4}};
        assertArrayEquals(B.getAllElemen(),hasil);
    }

    @Test
    public void testBarisKolom(){
        Matriks A = new Matriks();
        A.initAwal(2,2);
        assertEquals(2,A.getBaris());
        assertEquals(2,A.getKolom());
    }

    @Test
    public void testElemenSatuan(){
        Matriks A = new Matriks();
        A.initAwal(2,2);
        A.setElemenSatuan(0,0,1);
        A.setElemenSatuan(0,1,2);
        A.setElemenSatuan(1,0,3);
        A.setElemenSatuan(1,1, 4);
        assertEquals(3,A.getElemenSatuan(1,0));
    }

    @Test
    public void testSkalar(){
        Matriks A = new Matriks();
        A.initAwal(2,2);
        A.setElemenSatuan(0,0,1);
        A.setElemenSatuan(0,1,2);
        A.setElemenSatuan(1,0,3);
        A.setElemenSatuan(1,1, 4);
        A.jumlahMatriksSkalar(3);
        A.kaliMatriksSkalar(3);
        String expected = "4 5 "+lineSeparator()+"6 7 "+lineSeparator()+"3 6 "+lineSeparator()+"9 12";
        assertEquals(expected,
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void testJumlah2Matriks(){
        Matriks A = new Matriks();
        A.initAwal(2,2);
        A.setElemenSatuan(0,0,1);
        A.setElemenSatuan(0,1,2);
        A.setElemenSatuan(1,0,3);
        A.setElemenSatuan(1,1, 4);
        Matriks B = new Matriks();
        B.initAwal(2,2);
        B.setElemenSatuan(0,0,1);
        B.setElemenSatuan(0,1,2);
        B.setElemenSatuan(1,0,3);
        B.setElemenSatuan(1,1, 4);
        A.jumlahDuaMatriks(B);
        String expected = "2 4 "+lineSeparator()+"6 8";
        assertEquals(expected,
                outputStreamCaptor.toString().trim());
    }
}
