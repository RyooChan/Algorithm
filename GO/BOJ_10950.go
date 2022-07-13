package main

import "fmt"

func main() {
    var T int
    fmt.Scanln(&T)
    for i := 0; i < T; i++ {
        var A int
        var B int
        fmt.Scanln(&A, &B)
        fmt.Println(A+B)
    }
}
