function QuickSort(input: number[]): number[]
{
    if (!input || input.length === 0)
    {return input;}

    return QuickSortHelper(input, 0, input.length - 1);
}

function QuickSortHelper(input: number[], start: number, end: number): number[]
{
    if (start < end)
    {
        const mid = partition(input, start, end);
        QuickSortHelper(input, start, mid - 1);
        QuickSortHelper(input, mid + 1, end);
    }
    return input;
}

function partition(input: number[], start: number, end: number): number
{
    const pivot = input[end];
    const memoized_end = end--;
    while (start <= end)
    {
        if (input[start] < pivot)
        {
            start++;
        }
        else if (input[end] >= pivot)
        {
            end--;
        }
        else
        {
            const temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
    const temp = input[start];
    input[start] = input[memoized_end];
    input[memoized_end] = temp;
    return start;
}

function createRandomArray(): number[]
{
    const length = Math.floor(Math.random()*10);
    const array = [];
    for(let i = 0; i < length; i++)
    {
        array.push(Math.floor(Math.random() * 1000));
    }
    return array;
}

function isSorted(input: number[]): boolean
{
    for (let i = 1; i < input.length; i++)
    {
        if (input[i] < input[i-1]) return false;
    }
    return true;
}

for (let i = 0; i < 10; i++)
{   
    let input = createRandomArray();
    const output = QuickSort(input.slice());
    // console.log(`Input: ${input}`);
    // console.log(`Output: ${output}`);
    if (!isSorted(output))
    {
        console.log(`Input: ${input}`);
        console.log(`Output: ${output}`);
    }
}
