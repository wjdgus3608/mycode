#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector<vector<vector<int>>> v;
int visit[101][101][101];
int dz[]={0,0,0,0,1,-1};
int dy[]={-1,1,0,0,0,0};
int dx[]={0,0,-1,1,0,0};
int M,N,H;
int ret=-1;
struct mypair
{
    int y,x,z;
};
queue<mypair> q;
void bfs(){
    while(!q.empty()){
       struct mypair cur=q.front();
       q.pop();
        for(int i=0; i<6; i++){
            int nextz=cur.z+dz[i];
            int nexty=cur.y+dy[i];
            int nextx=cur.x+dx[i];
            if(nextz<0 ||nexty <0 || nextx<0 || nextz>=H ||nexty >=N || nextx>=M || visit[nextz][nexty][nextx]!=0) continue;
            if(v[nextz][nexty][nextx]==0){
                visit[nextz][nexty][nextx]=visit[cur.z][cur.y][cur.x]+1;
                v[nextz][nexty][nextx]=1;
                mypair m;
                m.z=nextz;
                m.y=nexty;
                m.x=nextx;
                q.push(m);
            }
        }
    }
    int mx=0;
    bool check=true;
    for(int k=0; k<H; k++){
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(v[k][i][j]==0){
                check=false;
                break;
            }
           mx=max(mx,visit[k][i][j]); 
        }
    }
    }
    if(check) ret=mx;
}
int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL), cin.tie(NULL);
    cin>>M>>N>>H;
    for(int k=0; k<H; k++){
        vector<vector<int>> temp1;
    for(int i=0; i<N; i++){
        
        vector<int> temp2;
        for(int j=0; j<M; j++){            
            int a;
            cin>>a;
            temp2.push_back(a);
            if(a==1) {
             struct mypair m;
                m.y=i;
                m.x=j;
                m.z=k;
                q.push(m);
            }
        }
        temp1.push_back(temp2);
    }
    v.push_back(temp1);
    }
   bfs();
   cout<<ret<<'\n';
    return 0;
}
