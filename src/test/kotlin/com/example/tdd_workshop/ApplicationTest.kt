package com.example.tdd_workshop

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    classes = [Application::class]
)
@ActiveProfiles("test")
class ApplicationTest {
}
