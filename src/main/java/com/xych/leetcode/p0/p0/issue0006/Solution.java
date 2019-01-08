package com.xych.leetcode.p0.p0.issue0006;

public class Solution
{
    public String convert(String str, int numRows)
    {
        if(numRows == 1)
            return str;
        int numFor = (numRows - 1) << 1;
        int len = str.length();
        int temp;
        int max = len / numFor * (numRows - 1) + ((temp = len % numFor) == 0 ? 0 : temp > numRows ? temp - numRows + 1 : 1);
        char[][] chars = new char[numRows][max];
        char[] s = str.toCharArray();
        int row, colomn, k;
        for(int i = 0; i < len; i++)
        {
            k = i % numFor;
            row = k < numRows ? k : numFor - k;
            colomn = i / numFor * (numRows - 1) + (k >= numRows ? k + 1 - numRows : 0);
            chars[row][colomn] = s[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < max; j++)
            {
                if(chars[i][j] > 0)
                {
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public String convert2(String str, int numRows)
    {
        if(str == null || str.length() == 0 || numRows < 2 || numRows >= str.length())
            return str;
        int len = str.length();
        int step = (numRows - 1) << 1;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(len);
        //First Row
        for(int i = 0; i < len; i += step)
        {
            sb.append(chars[i]);
        }
        //Center Row
        for(int rowIndex = 1; rowIndex < numRows - 1; rowIndex++)
        {
            int baseIndex = rowIndex;
            int nextBaseIndex = step - rowIndex;
            while(baseIndex < len)
            {
                sb.append(chars[baseIndex]);
                baseIndex += step;
                if(nextBaseIndex < len)
                {
                    sb.append(chars[nextBaseIndex]);
                    nextBaseIndex += step;
                }
            }
        }
        //Last Row
        for(int i = numRows - 1; i < len; i += step)
        {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public String convert3(String str, int numRows)
    {
        if(str == null || str.length() == 0 || numRows < 2 || numRows >= str.length())
            return str;
        int len = str.length();
        int step = (numRows - 1) << 1;
        int temp = numRows - 1;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(len);
        for(int rowIndex = 0; rowIndex < numRows; rowIndex++)
        {
            int baseIndex = rowIndex;
            int nextBaseIndex = step - rowIndex;
            while(baseIndex < len)
            {
                sb.append(chars[baseIndex]);
                baseIndex += step;
                if(rowIndex != 0 && rowIndex != temp)
                {
                    if(nextBaseIndex < len)
                    {
                        sb.append(chars[nextBaseIndex]);
                        nextBaseIndex += step;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "ABCDEFG";
        int numRows = 3;
        System.out.println(s);
        System.out.println();
        System.out.println(new Solution().convert3(s, numRows));
    }
}

