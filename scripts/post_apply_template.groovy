def springBootVersion = options['spring-boot-version'] ?: (options['boot-version'] ?: '3.3.2')
def springFrameworkVersion = switch(springBootVersion) {
    case { it.startsWith('3.4') } -> '6.2.0-M7'
    case { it.startsWith('3.3') || it.startsWith('3.2') } -> '6.1.12'
    case { it.startsWith('3.1') || it.startsWith('3.0') } -> '6.0.23'
}

def isMilestoneVersion = springBootVersion.contains('M') || springBootVersion.contains('RC')

ant.sequential {
    echo "Upgrade to Spring Boot $springBootVersion ..."

    replace(file: 'gradle.properties') {
        replacetoken "version="
        replacevalue """springBootVersion=$springBootVersion
springFrameworkVersion=$springFrameworkVersion
springDependencyManagementVersion=1.1.6
version="""
    }

    replace(file: 'settings.gradle') {
        replacetoken "rootProject.name = "
        replacevalue """pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven { url 'https://repo.gradle.org/gradle/libs-releases' }
    }
    plugins {
        id 'org.springframework.boot' version springBootVersion
        id 'io.spring.dependency-management' version springDependencyManagementVersion
        id "org.graceframework.grace-gsp" version graceVersion
        id "org.graceframework.grace-web" version graceVersion
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = """
    }

    replace(file: 'buildSrc/build.gradle') {
        replacetoken 'dependencies {'
        replacevalue """dependencies {
    implementation "org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion\""""
    }

    replace(file: 'build.gradle') {
        replacetoken 'group "'
        replacevalue '''ext['spring-boot.version'] = springBootVersion
ext['spring-framework.version'] = springFrameworkVersion

group "'''
    }

    if (isMilestoneVersion) {
        replace(file: 'buildSrc/build.gradle') {
            replacetoken 'mavenCentral()'
            replacevalue '''mavenCentral()
    maven { url 'https://repo.spring.io/milestone' }'''
        }
        replace(file: 'build.gradle') {
            replacetoken 'mavenCentral()'
            replacevalue '''mavenCentral()
    maven { url 'https://repo.spring.io/milestone' }'''
        }
        replace(file: 'settings.gradle') {
            replacetoken 'mavenCentral()'
            replacevalue '''mavenCentral()
        maven { url 'https://repo.spring.io/milestone' }'''
        }
    }

    echo 'Done'
}
