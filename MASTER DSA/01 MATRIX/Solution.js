var updateMatrix = function (mat) {
    let queue = []

    for (let i = 0; i < mat.length; i++) {
        for (let j = 0; j < mat[0].length; j++) {
            if (mat[i][j] == 0) {
                queue.push([i, j]);
            } else {
                mat[i][j] = Infinity;
            }
        }
    }


    while (queue.length) {
        let rem = queue.shift(); 
        let r = rem[0];
        let c = rem[1];

        let dir = [[1, 0], [0, 1], [-1, 0], [0, -1]];

        for (let i = 0; i < dir.length; i++) {
            let nr = r + dir[i][0];
            let nc = c + dir[i][1];

            if (nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] > mat[r][c] + 1) {
                mat[nr][nc] = mat[r][c] + 1;
                queue.push([nr, nc]);
            }
        }
    }

    return mat;
};

