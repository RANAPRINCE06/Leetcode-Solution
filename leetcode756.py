class Solution(object):
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        from collections import defaultdict

        mp = defaultdict(list)

        for s in allowed:
            mp[s[0:2]].append(s[2])

        memo = set()

        def dfs(row):
            if len(row) == 1:
                return True

            if row in memo:
                return False

            def build(idx, path):
                if idx == len(row) - 1:
                    return dfs("".join(path))

                pair = row[idx:idx + 2]
                if pair not in mp:
                    return False

                for ch in mp[pair]:
                    path.append(ch)
                    if build(idx + 1, path):
                        return True
                    path.pop()

                return False

            if not build(0, []):
                memo.add(row)
                return False

            return True

        return dfs(bottom)
