/*
스킬트리
문제 설명
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
입출력 예
skill	skill_trees	return
"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
입출력 예 설명
BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
CBADF: 가능한 스킬트리입니다.
AECB: 가능한 스킬트리입니다.
BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
*/

// 풀이
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] order = new int[skill.length()];
        
        // skill_trees의 개수만큼 진행한다.
        for(int i=0; i<skill_trees.length; i++)
        {
            int saved = -1;
            boolean learnable = true;
            
            // skill을 처음에 -1로 세팅, 매번 시작할 때 세팅해준다.
            for(int j=0; j<skill.length(); j++)
                order[j] = -1;
            
            // skill_tree에서 배우는 스킬들
            for(int k=0; k<skill_trees[i].length(); k++)
            {
                // 배울수 있는 스킬 순서
                for(int h=0; h<skill.length(); h++)
                {
                    // 둘이 곂치는 경우 순서를 파악해 저장한다.
                    if(skill.charAt(h) == skill_trees[i].charAt(k))
                        order[h] = k;
                }
            }
            
            // 저장된 순서를 판단한다.
            for(int k=0; k<skill.length(); k++)
            {
                // 배우는 스킬 중 순서에 해당하는 경우가 있는 경우
                if(order[k] != -1)
                {
                    // 그런데 이전 스킬트리를 배우지 않은 경우 배울수 없다.
                    if(k!=0)
                        if(order[k-1] == -1)
                        {
                            learnable = false;
                            break;
                        }
                    // saved는 선행스킬의 위치이다. 처음은 -1이고 현재 스킬에 따라 변한다.
                    // 만약 현재 배울 스킬이 선행스킬보다 뒤에 있다면 이를 저장하고 아니면 break
                    if(order[k] > saved)
                        saved = order[k];
                    else
                    {
                        learnable = false;
                        break;
                    }
                }
            }
            
            
            // 잘 나왔으면 answer++
            if(learnable)
                answer++;
        }

        
        return answer;
    }
}


