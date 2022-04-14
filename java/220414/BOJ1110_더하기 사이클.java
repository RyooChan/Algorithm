N = int(input())
Num = N

count =0
while 1:
    one = (Num//10) + (Num%10)
    Total = (Num%10)*10 + one%10
    
    count += 1
    Num = Total
    if N == Total :
        break
    
print(count)
