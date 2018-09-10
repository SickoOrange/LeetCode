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

//ac
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int length = nums.length;
        int count=0;
        for (int i = 0; count < length; i++) {
            int index = i;
            int prev = nums[i];
            do {
                index = (index + k) % length;
                int next = nums[index];
                nums[index] = prev;
                prev = next;
                count++;
            } while (index != i);
        }
    }
}
