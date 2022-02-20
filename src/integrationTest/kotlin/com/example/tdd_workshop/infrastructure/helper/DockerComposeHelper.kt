package com.example.tdd_workshop.infrastructure.helper

import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.containers.wait.strategy.WaitAllStrategy
import java.io.File

class DockerComposeHelper {
    companion object {

        private const val POSTGRES = "postgres"
        private const val POSTGRES_PORT = 5432

        fun create(): DockerComposeContainer<*> {
            return DockerComposeContainer<Nothing>(File("docker-compose.yml"))
                .apply { withLocalCompose(true) }
                .apply {
                    withExposedService(
                        POSTGRES,
                        POSTGRES_PORT,
                        WaitAllStrategy(WaitAllStrategy.Mode.WITH_INDIVIDUAL_TIMEOUTS_ONLY)
                            .apply { withStrategy(Wait.forListeningPort()) }
                            .apply {
                                withStrategy(
                                    Wait.forLogMessage(
                                        ".*database system is ready to accept connections.*",
                                        1
                                    )
                                )
                            }
                    )
                }

        }

        fun setSystemProperties(container: DockerComposeContainer<*>) {
            val postgresHost = container.getServiceHost(POSTGRES, POSTGRES_PORT)
            val postgresPort = container.getServicePort(POSTGRES, POSTGRES_PORT)
            System.setProperty("database.host", postgresHost)
            System.setProperty("database.port", postgresPort.toString())
        }
    }
}