import sys
sys.setrecursionlimit(10**6)
n,m=map(int,input().split())
graph=[]
visited=[[0]*m for _ in range(n)]

for i in range(n):
    graph.append(list(input()))
def dfs(x,y):
    global ans
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    #01
    if 0<=x<n and 0<=y<m and not visited[x][y]:
        visited[x][y]=1
        if graph[x][y]=="P":
            ans+=1
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            #02
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny]:
                if graph[nx][ny]!="X":
                    dfs(nx,ny)
ans=0
for i in range(n):
    for j in range(m):
    	#03
        if graph[i][j]=="I":
            dfs(i,j)
#04
if ans==0:
    print("TT")
else:
    print(ans)

