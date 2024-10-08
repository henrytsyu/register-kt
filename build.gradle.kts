plugins {
  kotlin("jvm") version "2.0.20"
  id("com.ncorti.ktfmt.gradle") version "0.20.1"
}

group = "com.henrytsyu"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(21)
}
