int totalHillWeight(int input1, int input2, int input3)
{
    int totalWeight = 0;

    for (int level = 1; level <= input1; level++)
    {
        int weightPerStar = input2 + (level - 1) * input3;
        totalWeight += level * weightPerStar;
    }

    return totalWeight;
}
