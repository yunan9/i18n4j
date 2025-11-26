plugins {
    `java-library`
}

repositories {
    mavenCentral()
    maven("https://central.sonatype.com/repository/maven-snapshots/")
}

dependencies {
    compileOnly(libs.jetbrains.annotations)

    compileOnly(libs.bundles.yunan9.series)
}