<h2>126. Word Ladder II</h2><h3>Hard</h3><hr><div><p>A <strong>transformation sequence</strong> from word <code>beginWord</code> to word <code>endWord</code> using a dictionary <code>wordList</code> is a sequence of words such that:</p>

<ul>
	<li>The first word in the sequence is <code>beginWord</code>.</li>
	<li>The last word in the sequence is <code>endWord</code>.</li>
	<li>Only one letter is different between each adjacent pair of words in the sequence.</li>
	<li>Every word in the sequence is in <code>wordList</code>.</li>
</ul>

<p>Given two words, <code>beginWord</code> and <code>endWord</code>, and a dictionary <code>wordList</code>, return <em>all the <strong>shortest transformation sequences</strong> from</em> <code>beginWord</code> <em>to</em> <code>endWord</code><em>, or an empty list if no such sequence exists.</em></p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
<strong>Output:</strong> [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
<strong>Output:</strong> []
<strong>Explanation:</strong> The endWord "cog" is not in wordList, therefore no possible<strong> </strong>transformation.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= beginWord.length &lt;= 10</code></li>
	<li><code>endWord.length == beginWord.length</code></li>
	<li><code>1 &lt;= wordList.length &lt;= 5000</code></li>
	<li><code>wordList[i].length == beginWord.length</code></li>
	<li><code>beginWord</code>, <code>endWord</code>, and <code>wordList[i]</code> consist of lowercase English letters.</li>
	<li><code>beginWord != endWord</code></li>
	<li>All the strings in <code>wordList</code> are <strong>unique</strong>.</li>
</ul>
</div>