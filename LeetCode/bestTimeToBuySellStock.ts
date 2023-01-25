function maxProfit(prices: number[]): number {

  let buyPrice = prices[0];
  let sellPrice = 0;

  for (let i = 1; i < prices.length; i++) {
    buyPrice = Math.min(buyPrice, prices[i]);
    sellPrice = Math.max(sellPrice, prices[i] - buyPrice);
  }
  return sellPrice;
};