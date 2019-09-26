def solution(A):
    a = A.pop(A.index(max(A)))
    b = A.pop(A.index(max(A)))
    c = A.pop(A.index(max(A)))
    return a * b * c
#44%