# T1부터 T46까지의 삼각수를 미리 계산
triangle = [n*(n+1)//2 for n in range(1, 46)]
# 3개의 삼각수의 합으로 표현되는지 배열
eureka = [0] * 1001

for i in triangle:
    for j in triangle:
        for k in triangle:
            if i + j + k <= 1000:
                eureka[i + j + k] = 1

n = int(input())
for _ in range(n):
    print(eureka[int(input())])
