package com.Reactor.Reactive.Practice;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prog9 {


    public static Mono<String> read(String fileName)
    {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Runnable> write(String fileName,String content)
    {
        return Mono.fromRunnable(() -> writeFile(fileName,content));
    }

    public static Mono<Runnable> delete(String fileName)
    {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static final Path PATH = Paths.get("src/main/java/com/Reactor/Reactive/Files");

    private static String readFile(String fileName)
    {
        try {
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String fileName, String content)
    {
        try {
            Files.writeString(PATH.resolve(fileName),content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String fileName)
    {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
