function isAnagram(s: string, t: string): boolean {
  return [...s].sort().join('') === [...t].sort().join('');
};