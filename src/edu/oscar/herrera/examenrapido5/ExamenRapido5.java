package edu.oscar.herrera.examenrapido5;

import java.util.ArrayList;
import java.util.List;

public class ExamenRapido5 {

    List solutionList = new ArrayList();
    boolean[] visited;

    void getAllSolutions(int column, int[] solution, boolean[] visited){
        if (column == solution.length){
            solutionList.add(solution);
        } else {
            for (int row = 0; row < solution.length; row++){
                if (visited[row]){
                    continue;
                }

                /*
                if (!isValidPlace(solution, row, column)){
                    continue;
                }
                 */

                int[] solutionClone = solution.clone();
                boolean[] visitedClone = visited.clone();
                solutionClone[column] = row;
                visitedClone[row] = true;
                getAllSolutions(column+1, solutionClone, visitedClone);
            }
        }
    }

    /*
    boolean isValidPlace(int[] solution, int row, int column){
        if (r1 == r2 || c1 == c2){
            return false;
        }
        if (r2 > r1){
            if (r1 - c1 == r2 - c2){
                return false;
            }
        }
        if (r1 > r2){
            if (r1 + c1 = r2 + c2){
                return false;
            }
        }
        return true;
    }
     */
}
