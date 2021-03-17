import parcs.*;

public class Gauss implements AM{
	public void run(AMInfo info) {
		Matrix matrix = (Matrix)info.parent.readObject();
		int currRow = info.parent.readInt();

		double coef;
		for(int k = 0; k < matrix.getN(); ++k) {
			for(int i = k + 1; i < matrix.getN(); ++i) {
				if(currRow == i) {
					coef = matrix.getA()[currRow][k] / matrix.getA()[k][k];
					for(int j = 0; j < matrix.getN(); ++j) {
						matrix.getA()[currRow][j] =
								matrix.getA()[currRow][j] - (coef * matrix.getA()[k][j]);
					}
					matrix.getB()[currRow] =
							matrix.getB()[currRow] - (coef * matrix.getB()[k]);
				}
			}	
		}
		
		currRow ++;
		if(currRow < matrix.getN()) {
			point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("Gauss");
            c.write(matrix);
            c.write(currRow);
            Matrix mt = (Matrix)c.readObject();
            info.parent.write(mt);
		}else
		{
			info.parent.write(matrix);
		}
	
	}
}
