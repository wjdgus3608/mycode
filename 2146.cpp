#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int N;
int map[101][101];
int visit[101][101];
int visit2[101][101];
int ret=99999;
queue<pair<int,int>> q;
int dy[]={-1,1,0,0};
int dx[]={0,0,-1,1};
int index=2;
int makenum(pair<int,int> start){
    q.push(start);
    visit[start.first][start.second]=1;
    map[start.first][start.second]=index;
    while(!q.empty()){
        int cury=q.front().first;
        int curx=q.front().second;
        q.pop();
        for(int i=0; i<4; i++){
            int nexty=cury+dy[i];
            int nextx=curx+dx[i];
            if(nexty<0 || nextx<0 || nexty>=N ||nextx>=N || visit[nexty][nextx]!=0) continue;
            if(map[nexty][nextx]==1){
                visit[nexty][nextx]=1;
                map[nexty][nextx]=index;
                q.push(make_pair(nexty,nextx));
            }
        }
    }
    index++;
    return 0;
}
void bfs(pair<int,int> start){
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++)
        visit2[i][j]=0;
    }
    int save=map[start.first][start.second];
    q.push(start);
    bool check=true;
    while(!q.empty() && check){
        int cury=q.front().first;
        int curx=q.front().second;
        q.pop();
        for(int i=0; i<4; i++){
            int nexty=cury+dy[i];
            int nextx=curx+dx[i];
            if(nexty<0 || nextx<0 || nexty>=N ||nextx>=N || visit2[nexty][nextx]!=0) continue;
            if(map[nexty][nextx]!=0 && map[nexty][nextx]!=save){
                 ret=min(ret,visit2[cury][curx]);
                 check=false;
                 while(!q.empty()) q.pop();
                 break;
            }
            if(map[nexty][nextx]==0){
                visit2[nexty][nextx]=visit2[cury][curx]+1;
                q.push(make_pair(nexty,nextx));
            }
        }
    }
    return ;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL),  cout.tie(NULL);
    cin>>N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            int num;
            cin>>num;
            map[i][j]=num; 
        }
    }
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(visit[i][j]==0 && map[i][j]==1)
            makenum(make_pair(i,j));
        }
    }

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(map[i][j]!=0)
            bfs(make_pair(i,j));
        }
    }
    if(ret==99999)
    ret=0;

    cout<<ret<<'\n';
    return 0;
}
