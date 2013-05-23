import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play-spring"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.h2database" % "h2" % "1.3.168",
      "org.springframework" % "spring-context" % "3.2.1.RELEASE",
      "org.springframework" % "spring-orm" % "3.2.1.RELEASE",
      "org.springframework" % "spring-context" % "3.2.1.RELEASE",
      "org.springframework" % "spring-orm" % "3.2.1.RELEASE",
      "org.springframework" % "spring-jdbc" % "3.2.1.RELEASE",
      "org.springframework" % "spring-tx" % "3.2.1.RELEASE",
      "org.springframework" % "spring-test" % "3.2.1.RELEASE" % "test",
      // "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final"
      "org.hibernate" % "hibernate-entitymanager" % "3.6.0.Final",
      "cglib" % "cglib" % "2.2.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
