class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] curr : prerequisites){
            adj.get(curr[1]).add(curr[0]);
        }

        int[] inorder = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            for(int next : adj.get(i)){
                inorder[next]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inorder[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;

            for(int i : adj.get(temp)){
                inorder[i]--;
                if(inorder[i] == 0){
                    q.offer(i);
                }
            }
        }
        return (numCourses == count);
    }
}
