n = int(input())
dic = {}

for i in range(n):
    key, value = input().split()
    if key not in dic:
        dic[key] = [value]
    else:
        dic[key].append(value)

dic2 = sorted(list(dic.keys()))
for j in dic2:
    for q in dic[j]:
        print(int(j), q)