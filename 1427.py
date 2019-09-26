nums = input()
num = []
for i in nums:
    num.append(int(i))

num.sort(reverse = True)

for j in num:
    print(j, end = "")