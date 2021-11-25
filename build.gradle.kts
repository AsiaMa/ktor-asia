val kotlinVersion: String by project
val ktorVersion: String by project
val koinVersion: String by project
val mysqlVersion: String by project
val exposedVersion: String by project
val hikariVersion: String by project
val logbackVersion: String by project
val assertjVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
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
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

    // koin
    implementation("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit4:$koinVersion")

    // mysql
    implementation("mysql:mysql-connector-java:$mysqlVersion")

    // exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    // hikari
    implementation("com.zaxxer:HikariCP:$hikariVersion")

    // logging
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // test
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}