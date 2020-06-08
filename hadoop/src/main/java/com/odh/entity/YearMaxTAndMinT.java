package com.odh.entity;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class YearMaxTAndMinT implements WritableComparable<YearMaxTAndMinT> {
    private String year; //年份
    private double maxTemp; //最高气温
    private double minTemp; //最低气温

    /**
     * 集群间通信使用的是RPC，传输信息是通过hadoop的序列化方式
     * @write 将对象序列化写入数据流中,传给接收方
     * @readFields 接受传来的数据流,将数据流反序列化为对象
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(year);
        dataOutput.writeDouble(maxTemp);
        dataOutput.writeDouble(minTemp);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.year = dataInput.readUTF();
        this.maxTemp = dataInput.readDouble();
        this.minTemp = dataInput.readDouble();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return year + "\t" + maxTemp + "\t" + minTemp;
    }

    @Override
        public int compareTo(YearMaxTAndMinT o) {
        //最高温度降序排序
        if(this.getMaxTemp() != o.getMaxTemp()) {
            return (int)(o.getMaxTemp() - this.getMaxTemp());
        }else {//相同则按最低温度升序排列
            if(this.getMinTemp() != o.getMinTemp())
                return (int)(this.getMinTemp() - o.getMinTemp());
            else{//两个维度的数都相同
                return 0;
            }
        }

    }
}
