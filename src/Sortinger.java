public abstract class Sortinger<T extends Comparable>
{
    public abstract void sort(T[] arr);

    public long sortWithTime(T[] arr) {
        long startMills = System.currentTimeMillis();
        sort(arr);
        return System.currentTimeMillis() - startMills;
    }
}
