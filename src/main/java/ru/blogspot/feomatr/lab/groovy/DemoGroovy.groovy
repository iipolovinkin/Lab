package ru.blogspot.feomatr.lab.groovy

/**
 * @author iipolovinkin
 * @since 11.07.2015
 */


println 1.class;
int a = 10
print(a.class)
javaString = '$hello'
groovyString = "GString a: ${a}"

print groovyString

bigGroovyString = """
    $javaString
    $groovyString
    $a
"""
print bigGroovyString
s = "0123456789"
println s[0..1]
println s[-2..1]