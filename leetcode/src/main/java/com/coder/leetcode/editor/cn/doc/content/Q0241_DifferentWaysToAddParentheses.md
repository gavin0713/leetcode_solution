<p>Given a string <code>expression</code> of numbers and operators, return <em>all possible results from computing all the different possible ways to group numbers and operators</em>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;2-1-1&quot;
<strong>Output:</strong> [0,2]
<strong>Explanation:</strong>
((2-1)-1) = 0 
(2-(1-1)) = 2
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;2*3-4*5&quot;
<strong>Output:</strong> [-34,-14,-10,-10,10]
<strong>Explanation:</strong>
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= expression.length &lt;= 20</code></li>
	<li><code>expression</code> consists of digits and the operator <code>&#39;+&#39;</code>, <code>&#39;-&#39;</code>, and <code>&#39;*&#39;</code>.</li>
	<li>All the integer values in the input expression are in the range <code>[0, 99]</code>.</li>
</ul>
<div><div>Related Topics</div><div><li>递归</li><li>记忆化搜索</li><li>数学</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 446</li><li>👎 0</li></div>