package database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {

    @Bean
    fun dataSource(): HikariDataSource {
        val config = HikariConfig().apply {
            jdbcUrl         = System.getenv("DB_URL")
                ?: "jdbc:postgresql://localhost:5432/task_scheduler"
            username        = System.getenv("DB_USER")
            password        = System.getenv("DB_PASSWORD")
            driverClassName = "org.postgresql.Driver"
            maximumPoolSize = 10
            minimumIdle     = 2
        }
        return HikariDataSource(config)
    }
}