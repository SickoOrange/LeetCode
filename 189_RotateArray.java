class Solution {

  public void rotate(int[] nums, int k) {

    //ac 
    k = k % nums.length;
    LinkedList<Integer> deque = new LinkedList<Integer>();
    for (int num : nums) {
      deque.add(num);
    }

    for (int i = 0; i < k; i++) {
      deque.add(0, deque.pollLast());
    }

    for (int i = 0; i < deque.size(); i++) {
      nums[i] = deque.get(i);
    }
  }
}
