import com.simplytyped.Antlr4Plugin
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import scalariform.formatter.preferences._
import scalariform.formatter.preferences.{AlignSingleLineCaseStatements, DanglingCloseParenthesis, DoubleIndentClassDeclaration, Preserve, PreserveSpaceBeforeArguments, SpacesAroundMultiImports}

name          := "beard"
organization  := "de.zalando"
version       := "0.2.1-SNAPSHOT"
licenses      += ("Apache-2.0", url("http://www.apache.org/licenses/"))

scalaVersion := "2.12.8"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

val antlrVersion = "4.7.2"

enablePlugins(Antlr4Plugin)

antlr4GenListener in Antlr4 := true

antlr4GenVisitor in Antlr4 := true

antlr4Dependency in Antlr4 := "org.antlr" % "antlr4" % antlrVersion

antlr4PackageName in Antlr4 := Some("de.zalando.beard")

libraryDependencies ++= {
  Seq(
    "org.antlr"                    % "antlr4"                               % antlrVersion
                                                                              exclude("org.antlr", "ST4")
                                                                              exclude("org.antlr", "antlr-runtime"),
    "org.scala-lang"               % "scala-reflect"                        % scalaVersion.value,
    "org.scala-lang.modules"      %% "scala-xml"                            % "2.0.0-M1",
    "io.monix"                    %% "monix"                                % "3.1.0",
    "org.slf4j"                    % "slf4j-api"                            % "1.7.7",
    "ch.qos.logback"               % "logback-classic"                      % "1.1.7",
    "org.scalatest"               %% "scalatest"                            % "3.2.0-M2"          % "test",
    "com.mitchellbosecke"          % "pebble"                               % "1.6.0"          % "test",
    "org.freemarker"               % "freemarker"                           % "2.3.23"         % "test",
    "com.github.spullara.mustache.java"   % "compiler"                      % "0.9.1"          % "test",
    "com.github.jknack"            % "handlebars"                           % "2.2.2"          % "test",
    "de.neuland-bfi"               % "jade4j"                               % "0.4.0"          % "test",
    "com.storm-enroute"           %% "scalameter"                           % "0.19"          % "test"
  )
}



publishMavenStyle       := true
bintrayOrganization     := Some("zalando")
