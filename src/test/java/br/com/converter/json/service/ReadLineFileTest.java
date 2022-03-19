package br.com.converter.json.service;


import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ReadLineFileTest {

    @Test
    public void testReadLineFileOneLine() throws IOException {
        ReadLineFile readLine = new ReadLineFile();
        var line = readLine.readingLineFile("./src/main/resources/fileOneLine.txt");

        assertThat(line).isEqualTo("0000000071                               Everett Beahan00000007610000000004    1881.5420210702");
    }

    @Test
    public void testReadLineFileOneLine2() throws IOException {
        ReadLineFile readLine = new ReadLineFile();

        assertThatExceptionOfType(FileNotFoundException.class).isThrownBy(() ->{
            var line = readLine.readingLineFile("./fileNotFound");
        }).withMessageContaining("./fileNotFound (No such file or directory)");
    }
}