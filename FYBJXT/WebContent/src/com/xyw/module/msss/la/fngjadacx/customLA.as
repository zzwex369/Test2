/**
 *得到是否包含的结果  是 true 否 false 
 */
private function getCheckEnabled(arr:Array,source:Array,isSplice:Boolean=false):Array
{
	var result:Boolean=false;
	for(var i:int=0;i<source.length;i++)
	{
		if(result)
			break;
		if(source[i]=='0')
		{
			source.splice(i,1);
			--i;
			continue;
		}
		for(var j:int=0;j<arr.length;j++)
		{
			if(source[i]==arr[j])
			{
				result=true;
				if(isSplice)
					source.splice(i,1);
				break;
			}
		}
		
	}
	return [result,source];
}