import de.johoop.jacoco4sbt.{ScalaHTMLReport, XMLReport}

name := "SIC"

version := "0.0.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

javaOptions in Test += "-Dtest.timeout=600000"
javaOptions in Test ++= Seq("-Dconfig.resource=application.unitTest.conf")

jacoco.settings
testOptions in jacoco.Config += Tests.Setup( () => System.setProperty("config.file", "conf/application.unitTest.conf") )
parallelExecution in jacoco.Config := false
jacoco.reportFormats in jacoco.Config := Seq(
  XMLReport(encoding = "utf-8"),
  ScalaHTMLReport(withBranchCoverage = true))
jacoco.excludes in jacoco.Config := Seq("views*", "*Routes*", "controllers*routes*", "controllers*Reverse*", "controllers*javascript*", "controller*ref*", "actors*", "forms*", "global*", "models*")


libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  javaWs,
  evolutions,
  "org.hibernate" % "hibernate-core" % "5.2.10.Final",
  "mysql" % "mysql-connector-java" % "5.1.39",
  "dom4j" % "dom4j" % "1.6.1",
  "com.sendgrid" % "sendgrid-java" % "2.2.2",
  "junit" % "junit" % "4.11",
  "org.easytesting" % "fest-assert" % "1.4",
  "org.mockito" % "mockito-all" % "1.10.19",
  "uk.co.jemos.podam" % "podam" % "7.0.4.RELEASE",
  "org.julienrf" %% "play-jsmessages" % "2.0.0",
  "com.lowagie" % "itext" % "2.1.7",
  "net.sourceforge.jexcelapi" % "jxl" % "2.6.10",
  "net.sf.jasperreports" % "jasperreports" % "5.5.1",
  "com.amazonaws" % "aws-java-sdk" % "1.11.93",
  "io.jsonwebtoken" % "jjwt" % "0.7.0",
  "commons-io" % "commons-io" % "2.5",
  "org.apache.poi" % "poi" % "3.12",
  "org.apache.poi" % "poi-ooxml" % "3.12",
  "com.googlecode.json-simple" % "json-simple" % "1.1.1",
  "com.google.code.gson" % "gson" % "2.2.2",
  "org.postgresql" % "postgresql" % "9.2-1002-jdbc4"
)
