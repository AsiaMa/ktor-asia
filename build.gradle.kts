val kotlinVersion: String by project
val ktorVersion: String by project
val koinVersion: String by project
val mysqlVersion: String by project
val exposedVersion: String by project
val hikariVersion: String by project
val logbackVersion: String by project
val assertjVersion: String by project
val flywayVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
    id("org.flywaydb.flyway") version "7.15.0"
}

group = "com.asia"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")

    // ktor
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

    // koin
    implementation("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit4:$koinVersion")

    // mysql
    implementation("mysql:mysql-connector-java:$mysqlVersion")

    // hikari
    implementation("com.zaxxer:HikariCP:$hikariVersion")

    // exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    // flywaydb
    implementation("org.flywaydb:flyway-core:$flywayVersion")

    // logging
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // test
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("io.rest-assured:rest-assured:4.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}


flyway {
    driver = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://localhost/my_ktor?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT"
    user = "root"
    password = "123456"
    locations = arrayOf("classpath:com/asia/db/migration")
}

tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()
}