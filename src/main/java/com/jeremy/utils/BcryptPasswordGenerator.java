package com.jeremy.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BcryptPasswordGenerator {
    private static final int NUM_PASSWORDS = 1_000_000;
    private static final int THREAD_COUNT = 10;  // Use 10 threads for parallel processing
    private static final String PASSWORD = "password123";
    private static final String CSV_FILE = "hashed_passwords.csv";
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            writer.write("hashed_password\n"); // CSV header

            for (int i = 0; i < THREAD_COUNT; i++) {
                executor.execute(() -> {
                    try {
                        StringBuilder batch = new StringBuilder();
                        while (true) {
                            int id = counter.incrementAndGet();
                            if (id > NUM_PASSWORDS) break;

                            // Generate hashed password
                            String hashedPassword = passwordEncoder.encode(PASSWORD);
                            batch.append(hashedPassword).append("\n");

                            // Print progress every 100,000 records
                            if (id % 100000 == 0) {
                                System.out.println("Generated: " + id);
                            }

                            // Write batch to file every 1000 records
                            if (id % 1000 == 0) {
                                synchronized (writer) { // Prevent file corruption
                                    writer.write(batch.toString());
                                    writer.flush();
                                }
                                batch.setLength(0);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(1000);
            }

            System.out.println("✅ 1 Million Bcrypt passwords saved to " + CSV_FILE);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
