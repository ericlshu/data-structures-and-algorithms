/*
 * Description : 视频拼接
 * <p>
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
 * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * <p>
 * 示例 1：.
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * <p>
 * 示例 2：
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * <p>
 * 示例 3：
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * <p>
 * 示例 4：
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 * <p>
 * 提示：
 * <p>
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 *
 */
/**
 * @param {number[][]} clips
 * @param {number} T
 * @return {number}
 */
var videoStitching = function(clips, T) {
    var t = T;
    var arr = clips;
    for (let i = 1; i < arr.length; i++) {
        for (let j = i; j > 0; j--) {
            if (arr[j][0] < arr[j-1][0]) {
                let pre = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = pre;
            }
        }
    }
    var buchang = [0,0];
    var sArr = [],tag=false;
    for(var i=0;i<arr.length;i++){
        //最小值比步长最大值大  ==若与步长能够连接起来，即最小值等于步长的最大值，那这个值就放到暂存器里面，最为步长连接，若连不起来，直接输入-1，代表不能连接
        //最大值比步长最小值小 ==基本不存在，数组是按需排列的，放弃
        //最小值比步长最小值大，最大值比步长最大值大 == 数据暂存，更新步长。
        //最小值比步长最小值小或相等，最大值比步长最小值大  ==这个值放弃 ==最大值比步长最大值小或相当的，这个数值放弃。
        const bc = buchang[buchang.length-1];
        if(arr[i][1] <= bc  ){//若这个值的最大点比步长的最大点小的话，舍弃这个点
        }else if(arr[i][0] > bc){//数据不连续,结束循环。
            tag = true;
            break;
        }else if(arr[i][1] > bc){
            if(sArr.length > 0){//更新步长和已列入列表的数据
                const lastV = sArr[sArr.length-1];
                if(arr[i][0] == lastV[0]){//同一个七点，废弃前一个节点，存入现在的节点。
                    //更新步长
                    buchang.pop();
                    buchang.push(arr[i][1]);
                    sArr.pop();
                    sArr.push(arr[i]);
                }else{//不同七点：判断当前值节点是否在废弃前一个节点时还能连接，若不能，则push当前节点，若能，则废弃当前节点，push当前节点
                    if(buchang[buchang.length-2] <　arr[i][0]){//若不能，则push当前节点，变更步长
                        sArr.push(arr[i]);
                        buchang.push(arr[i][1]);
                    }else{
                        //更新步长
                        buchang.pop();
                        buchang.push(arr[i][1]);
                        sArr.pop();
                        sArr.push(arr[i]);
                    }
                }
            }else{
                const temp = arr[i][1];
                buchang.pop();
                buchang.push(temp);
                sArr.push(arr[i])
            }
        }
        if( buchang[buchang.length-1] >= t){
            break;
        }
    }
    if(buchang[buchang.length-1] < t){
        tag=true;
    }
    return tag? -1:sArr.length;
};