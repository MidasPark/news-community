import { fetchNYT } from '.'

export default defineEventHandler(async (event) => {
  const { list = 'hardcover-fiction', date = 'current' } = getQuery(event)
  
  const response = await fetchNYT(`/books/v3/lists/${date}/${list}.json`)
  
  return {
    books: response.results.books.map(book => ({
      id: book.primary_isbn13,
      title: book.title,
      author: book.author,
      description: book.description,
      publisher: book.publisher,
      rank: book.rank,
      rank_last_week: book.rank_last_week,
      weeks_on_list: book.weeks_on_list,
      buy_links: book.buy_links,
      book_image: book.book_image
    }))
  }
}) 