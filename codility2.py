def solution(A):
    B = [0]*len(A)
    C = 0
    for i in A:
        B[i] = B[i] + 1

    for j in B:
        if B[j] != 0:
            C = C + 1
    return C
#16%