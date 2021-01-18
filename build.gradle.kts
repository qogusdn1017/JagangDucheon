plugins {
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.baehyeonwoo.jagangducheon"
version = "0.2"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/") // PaperMC Maven Repo
}

dependencies {
    implementation("com.destroystokyo.paper:paper-api:1.13.2-R0.1-SNAPSHOT") // Paper
    implementation(kotlin("stdlib"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }

    create<Copy>("dist") {
        from(shadowJar)
        into(".\\") // Directly into code root directory.
    }
}