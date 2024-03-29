def sort(xs: Array[Int])
{
	def swap(i: Int, j: Int)
	{
		//val t = xs(i); 
		//xs(i) = xs(j); 
		//xs(j) = t
		xs(j) = xs(i) + xs(j);
		xs(i) = xs(j) - xs(i);
		xs(j) = xs(j) - xs(i);

	}	
	def sort1(l: Int, r: Int)
	{
		val pivot = xs((l + r) / 2)
		var i = l; var j = r
		while(i <= j)
		{
			while(pivot > xs(i)) i += 1
			while(pivot < xs(j)) j -= 1
			if (i <= j)
			{
				swap(i, j)
				i += 1
				j -= 1
			}
		}
		if(l < j) sort1(l, j)
		if(j < r) sort1(i, r)
	}
	sort1(0, xs.length - 1)
}

