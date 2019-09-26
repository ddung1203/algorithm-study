n = int(input())

answer = 0

a = list(map(int, input().split()))
b = list(map(int, input().split()))


while True:
    answer = answer + (a.pop(a.index(min(a)))) * (b.pop(b.index(max(b))))
    if len(a) == 0:
        break
print(answer)