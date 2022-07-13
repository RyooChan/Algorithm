package main

import "fmt"

func main() {
    var T int
    var ans int = 0
    fmt.Scanln(&T)
    for i := 1; i <= T; i++ {
        ans += i
    }
    fmt.Println(ans)
}
