#include <iostream>
#include <string>

using namespace std;

#define MAX_SIZE 11
#define MAX_INF 987654321

#define LEFT 0
#define RIGHT 1
#define UP 2
#define DOWN 3

int n, m;
int board[MAX_SIZE][MAX_SIZE];
int ans = MAX_INF;

bool rhole, bhole;

pair<int, int> red;
pair<int, int> blue;
pair<int, int> hole;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

// 반대방향
int GetConverse(int direction)
{
    // 전에 기울인 적이 없으면
    if (direction == -1) return -1;

    if (direction == LEFT) return RIGHT;
    else if (direction == RIGHT) return LEFT;
    else if (direction == UP) return DOWN;
    else if (direction == DOWN) return UP;
}

int MoveRow(int x, int y, int direction)
{
    int next_x = x;

    if (direction == UP)
    {
        for (int row = x-1; row > 0; row--)
        {
            if (board[row][y] == '#')
                break;
            else if (board[row][y] == 'O')
            {
                next_x = row;
                break;
            }
            else
                next_x = row;
        }
    }
    else if (direction == DOWN)
    {
        for (int row = x + 1; row < n-1; row++)
        {
            if (board[row][y] == '#')
                break;
            else if (board[row][y] == 'O')
            {
                next_x = row;
                break;
            }
            else
                next_x = row;
        }
    }

    return next_x;
}

int MoveCol(int x,int y,int direction)
{
    int next_y=y;

    if (direction == LEFT)
    {
        for (int col = y - 1; col > 0; col--)
        {
            if (board[x][col] == '#')
                break;
            else if (board[x][col] == 'O')
            {
                next_y = col;
                break;
            }
            else
                next_y = col;
        }
    }
    else if (direction == RIGHT)
    {
        for (int col = y + 1; col < m-1; col++)
        {
            if (board[x][col] == '#')
                break;
            else if (board[x][col] == 'O')
            {
                next_y = col;
                break;
            }
            else
                next_y = col;
        }
    }

    return next_y;
}

void MoveBall(int direction)
{
    if (direction == UP || direction == DOWN)
    {
        red.first = MoveRow(red.first, red.second, direction);
        blue.first = MoveRow(blue.first, blue.second, direction);
    }
    else if (direction == LEFT || direction == RIGHT)
    {
        red.second = MoveCol(red.first, red.second, direction);
        blue.second = MoveCol(blue.first, blue.second, direction);
    }
}

void CheckHole()
{

    if (red.first == hole.first && red.second == hole.second)
        rhole = true;
    if (blue.first == hole.first && blue.second == hole.second)
        bhole = true;

}

// 방향에 따른 빨간공, 파란공 우선순위 
int GetPriority(int direction)
{
    int ret_priority = -1;

    if (direction == LEFT)
    {
        if (red.second < blue.second)
            ret_priority = 0;
        else if (red.second > blue.second)
            ret_priority = 1;
    }
    else if (direction == RIGHT)
    {
        if (red.second > blue.second)
            ret_priority = 0;
        else if (red.second < blue.second)
            ret_priority = 1;
    }
    else if (direction == UP) 
    {
        if (red.first < blue.first)
            ret_priority = 0;
        else if (red.first > blue.first)
            ret_priority = 1;
    }
    else if (direction == DOWN)
    {
        if (red.first > blue.first)
            ret_priority = 0;
        else if (red.first < blue.first)
            ret_priority = 1;
    }

    return ret_priority;
}

void MoveSameBall(int priority, int direction)
{
    if (direction == LEFT)
    {
        if (priority == 0) blue.second += 1;
        else red.second += 1;
    }
    else if (direction == RIGHT)
    {
        if (priority == 0) blue.second -= 1;
        else red.second -= 1;
    }
    else if (direction == UP)
    {
        if (priority == 0) blue.first += 1;
        else red.first += 1;
    }
    else if (direction == DOWN)
    {
        if (priority == 0) blue.first -= 1;
        else red.first -= 1;
    }
}

void Dfs(int prev_direction, int depth)
{
    if (depth > 10)
    {
        rhole = false;
        bhole = false;
        return;
    }

    if (bhole == true)
    {
        rhole = false;
        bhole = false;
        return;
    }
    else
    {
        if (rhole == true)
        {
            rhole = false;
            bhole = false;
            ans = min(ans, depth);
            return;
        }
    }

    int red_x = red.first, red_y = red.second;
    int blue_x = blue.first, blue_y = blue.second;

    for (int k = 0; k < 4; k++)
    {
        // 이전에 기울인 방향과 반대 방향은 기울이지 않는다.
        if (k == prev_direction || k == GetConverse(prev_direction)) continue;

        // 빨강이 앞이면 0, 파랑이 앞이면 1
        int priority = GetPriority(k);

        MoveBall(k);
        CheckHole();

        if (red.first == blue.first && red.second == blue.second)
        {
            MoveSameBall(priority, k);
        }

        Dfs(k, depth + 1);

        red.first = red_x;
        red.second = red_y;
        blue.first = blue_x;
        blue.second = blue_y;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        string tmp;
        cin >> tmp;
        for (int j = 0; j < m; j++)
        {
            board[i][j] = tmp[j];
            if (board[i][j] == 'R') red = make_pair(i, j);
            else if (board[i][j] == 'B') blue = make_pair(i, j);
            else if (board[i][j] == 'O') hole = make_pair(i, j);
        }
    }

    // 처음에는 기울인 방향이 없기 때문에 -1을 준다
    Dfs(-1, 0);

    if (ans == MAX_INF)
        cout << -1 << "\n";
    else
        cout << ans << "\n";

    return 0;
}
