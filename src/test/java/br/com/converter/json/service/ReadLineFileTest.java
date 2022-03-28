package br.com.converter.json.service;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ReadLineFileTest {

    private ReadLineFile read = new ReadLineFile();

    @Test
    public void shouldReturnBufferReaderForOneReadLine() throws IOException {
        var bufferRead = read.readingLineFile("./src/main/resources/fileOneLine.txt");

        assertThat(bufferRead.readLine()).isEqualTo("0000000071                               Everett Beahan00000007610000000004    1881.5420210702");
    }

    @Test
    public void shouldReturnBufferReaderForTwoReadLine() throws IOException {
        var bufferRead = read.readingLineFile("./src/main/resources/fileTwoLine.txt");

        assertThat(bufferRead.readLine()).isEqualTo("0000000070                              Palmer Prosacco00000007530000000033     1836.7420210308");
        assertThat(bufferRead.readLine()).isEqualTo("0000000075                                  Bobbie Batz000000079800000000226    1578.5720211116");
    }

    @Test
    public void shouldThrowsFileNotFoundException() throws IOException {

        assertThatExceptionOfType(FileNotFoundException.class).isThrownBy(() ->{
            var bufferRead = read.readingLineFile("./fileNotFound");
        }).withMessageContaining("./fileNotFound (No such file or directory)");
    }
}